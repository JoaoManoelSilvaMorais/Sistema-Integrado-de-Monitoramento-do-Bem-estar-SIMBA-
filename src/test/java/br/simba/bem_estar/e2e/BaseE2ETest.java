package br.simba.bem_estar.e2e;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import br.simba.bem_estar.conquista.ConquistaUsuarioRepository;
import br.simba.bem_estar.lembrete.LembreteRepository;
import br.simba.bem_estar.meta.MetaAguaRepository;
import br.simba.bem_estar.meta.MetaRepository;
import br.simba.bem_estar.perfil.PerfilRepository;
import br.simba.bem_estar.registroAgua.RegistroAguaRepository;
import br.simba.bem_estar.registroExercicio.RegistroExercicioRepository;
import br.simba.bem_estar.registroSono.RegistroSonoRepository;
import br.simba.bem_estar.rotina.RotinaLembreteRepository;
import br.simba.bem_estar.rotina.RotinaRepository;
import br.simba.bem_estar.sintoma.RegistroSintomaRepository;
import br.simba.bem_estar.user.UserRepository;

/**
 * Base compartilhada dos testes Ponta a Ponta (E2E) com Selenium WebDriver e
 * servidor Spring Boot real em porta aleatória.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseE2ETest {

    private static final Duration TIMEOUT_PADRAO = Duration.ofSeconds(15);
    private static final DateTimeFormatter ISO_LOCAL_MINUTO = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    @LocalServerPort
    protected int porta;

    @Autowired
    protected RotinaLembreteRepository rotinaLembreteRepository;
    @Autowired
    protected RotinaRepository rotinaRepository;
    @Autowired
    protected LembreteRepository lembreteRepository;
    @Autowired
    protected ConquistaUsuarioRepository conquistaUsuarioRepository;
    @Autowired
    protected MetaRepository metaRepository;
    @Autowired
    protected MetaAguaRepository metaAguaRepository;
    @Autowired
    protected RegistroSintomaRepository registroSintomaRepository;
    @Autowired
    protected RegistroAguaRepository registroAguaRepository;
    @Autowired
    protected RegistroExercicioRepository registroExercicioRepository;
    @Autowired
    protected RegistroSonoRepository registroSonoRepository;
    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected PerfilRepository perfilRepository;

    protected WebDriver driver;
    protected WebDriverWait espera;

    @BeforeAll
    void iniciarNavegador() {
        EdgeOptions opcoes = criarOpcoesEdge();
        driver = new EdgeDriver(opcoes);
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        espera = new WebDriverWait(driver, TIMEOUT_PADRAO);
    }

    @AfterAll
    void encerrarNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeEach
    void prepararAmbiente() {
        limparEstadoNavegador();
        if (deveLimparBancoAntesDoTeste()) {
            limparBanco();
        }
    }

    /**
     * Permite que testes com massa pré-carregada (ex.: perfil {@code demo})
     * preservem o banco populado pelo seeder de inicialização.
     */
    protected boolean deveLimparBancoAntesDoTeste() {
        return true;
    }

    protected void limparBanco() {
        rotinaLembreteRepository.deleteAllInBatch();
        rotinaRepository.deleteAllInBatch();
        lembreteRepository.deleteAllInBatch();
        conquistaUsuarioRepository.deleteAllInBatch();
        metaRepository.deleteAllInBatch();
        metaAguaRepository.deleteAllInBatch();
        registroSintomaRepository.deleteAllInBatch();
        registroAguaRepository.deleteAllInBatch();
        registroExercicioRepository.deleteAllInBatch();
        registroSonoRepository.deleteAllInBatch();
        userRepository.deleteAllInBatch();
        perfilRepository.deleteAllInBatch();
    }

    private void limparEstadoNavegador() {
        if (driver == null) {
            return;
        }
        String urlAtual = driver.getCurrentUrl();
        if (urlAtual != null && urlAtual.startsWith("http")) {
            ((JavascriptExecutor) driver).executeScript(
                    "sessionStorage.clear(); localStorage.clear();");
            driver.manage().deleteAllCookies();
        }
        // Interrompe timers/redirecionamentos pendentes da página anterior antes do próximo teste
        driver.get("about:blank");
    }

    private EdgeOptions criarOpcoesEdge() {
        EdgeOptions opcoes = new EdgeOptions();
        Path binarioEdge = localizarBinarioEdge();
        if (binarioEdge != null) {
            opcoes.setBinary(binarioEdge.toString());
        }
        opcoes.setPageLoadStrategy(PageLoadStrategy.EAGER);
        opcoes.addArguments(
                "--headless=new",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--disable-gpu",
                "--disable-background-timer-throttling",
                "--disable-backgrounding-occluded-windows",
                "--disable-renderer-backgrounding",
                "--disable-features=CalculateNativeWinOcclusion",
                "--window-size=1366,900",
                "--lang=pt-BR");
        return opcoes;
    }

    /**
     * Localiza o executável do Microsoft Edge tanto no caminho padrão quanto em
     * instalações baseadas em {@code EdgeCore\<versão>\msedge.exe}.
     */
    private Path localizarBinarioEdge() {
        String propriedade = System.getProperty("simba.edge.binary");
        if (propriedade != null && !propriedade.isBlank()) {
            Path customizado = Path.of(propriedade);
            if (Files.isRegularFile(customizado)) {
                return customizado;
            }
        }

        List<Path> candidatosFixos = List.of(
                Path.of("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe"),
                Path.of("C:\\Program Files\\Microsoft\\Edge\\Application\\msedge.exe"),
                Path.of(System.getProperty("user.home"), "AppData", "Local", "Microsoft", "Edge", "Application", "msedge.exe"));
        for (Path candidato : candidatosFixos) {
            if (Files.isRegularFile(candidato)) {
                return candidato;
            }
        }

        List<Path> pastasEdgeCore = List.of(
                Path.of("C:\\Program Files (x86)\\Microsoft\\EdgeCore"),
                Path.of("C:\\Program Files\\Microsoft\\EdgeCore"));
        for (Path pasta : pastasEdgeCore) {
            if (!Files.isDirectory(pasta)) {
                continue;
            }
            try (Stream<Path> subpastas = Files.list(pasta)) {
                Path encontrado = subpastas
                        .filter(Files::isDirectory)
                        .map(dir -> dir.resolve("msedge.exe"))
                        .filter(Files::isRegularFile)
                        .sorted(Comparator.comparing((Path p) -> p.getParent().getFileName().toString()).reversed())
                        .findFirst()
                        .orElse(null);
                if (encontrado != null) {
                    return encontrado;
                }
            } catch (Exception ignored) {
                // Segue para a próxima pasta ou permite o Selenium Manager resolver pelo SO
            }
        }
        return null;
    }

    protected String url(String caminho) {
        String normalizado = caminho.startsWith("/") ? caminho : "/" + caminho;
        return "http://localhost:" + porta + normalizado;
    }

    protected void abrir(String caminho) {
        String destino = url(caminho);
        try {
            driver.get(destino);
        } catch (TimeoutException erroTransitorio) {
            driver.get(destino);
        }
    }

    protected WebElement esperarVisivel(By seletor) {
        return espera.until(ExpectedConditions.visibilityOfElementLocated(seletor));
    }

    protected WebElement esperarClicavel(By seletor) {
        return espera.until(ExpectedConditions.elementToBeClickable(seletor));
    }

    protected void rolarParaCentro(WebElement elemento) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});",
                elemento);
    }

    protected void clicar(By seletor) {
        WebElement elemento = esperarClicavel(seletor);
        rolarParaCentro(elemento);
        elemento.click();
    }

    protected void clicarElemento(WebElement elemento) {
        espera.until(ExpectedConditions.elementToBeClickable(elemento));
        rolarParaCentro(elemento);
        elemento.click();
    }

    protected void preencher(By seletor, String texto) {
        WebElement elemento = esperarVisivel(seletor);
        rolarParaCentro(elemento);
        elemento.clear();
        elemento.sendKeys(texto);
    }

    protected void preencherSelectPorValor(By seletor, String valor) {
        WebElement elemento = esperarVisivel(seletor);
        rolarParaCentro(elemento);
        new Select(elemento).selectByValue(valor);
    }

    /**
     * Define valores em campos {@code input[type="datetime-local"]} e {@code input[type="time"]}
     * disparando os eventos DOM {@code input} e {@code change}, evitando inconsistências de máscara
     * regional entre Chromium e {@code sendKeys}.
     */
    protected void preencherDataHora(By seletor, String valorIso) {
        WebElement campo = esperarVisivel(seletor);
        preencherDataHora(campo, valorIso);
    }

    protected void preencherDataHora(WebElement campo, String valorIso) {
        rolarParaCentro(campo);
        ((JavascriptExecutor) driver).executeScript(
                "const desc = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value');"
                        + "desc.set.call(arguments[0], arguments[1]);"
                        + "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
                        + "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                campo,
                valorIso);
    }

    protected String formatarDataHoraIso(LocalDateTime dataHora) {
        return dataHora.withSecond(0).withNano(0).format(ISO_LOCAL_MINUTO);
    }

    protected void aceitarAlerta() {
        espera.until(ExpectedConditions.alertIsPresent()).accept();
    }

    protected void esperarTexto(By seletor, String trecho) {
        espera.until(ExpectedConditions.textToBePresentInElementLocated(seletor, trecho));
    }

    protected void esperarUrlContendo(String trecho) {
        espera.until(ExpectedConditions.urlContains(trecho));
    }

    protected void esperarTokenSessao() {
        espera.until(d -> {
            Object token = ((JavascriptExecutor) d).executeScript("return sessionStorage.getItem('jwtToken');");
            return token != null && !token.toString().isBlank();
        });
    }

    protected void cadastrarViaInterface(String nome, String username, String email, String senha) {
        abrir("/login.html");
        preencher(By.id("nome"), nome);
        preencher(By.id("username"), username);
        preencher(By.id("email"), email);
        preencher(By.id("senha"), senha);
        preencher(By.id("confirma_senha"), senha);
        clicar(By.cssSelector("button.btn-submit"));
        esperarUrlContendo("entrar.html");
    }

    protected void entrarViaInterface(String username, String senha) {
        abrir("/entrar.html");
        preencher(By.id("username"), username);
        preencher(By.id("senha"), senha);
        clicar(By.cssSelector("form button[type='submit']"));
        esperarUrlContendo("index.html");
        esperarTokenSessao();
    }

    protected void cadastrarEEntrarViaInterface(String nome, String username, String email, String senha) {
        cadastrarViaInterface(nome, username, email, senha);
        entrarViaInterface(username, senha);
    }
}
