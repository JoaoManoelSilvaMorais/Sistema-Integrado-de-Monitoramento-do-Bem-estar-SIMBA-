package br.simba.bem_estar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Ordem das páginas: quem abre http://localhost:8080/ vê primeiro a apresentação do SIMBA
 * (inicio.html), que leva para Entrar / Criar conta. A dashboard continua em /index.html
 * e só abre com login (js/protecao.js).
 */
@Configuration
public class PaginasConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/inicio.html");
    }
}
