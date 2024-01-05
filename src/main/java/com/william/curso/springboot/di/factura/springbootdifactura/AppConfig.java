package com.william.curso.springboot.di.factura.springbootdifactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.william.curso.springboot.di.factura.springbootdifactura.models.Item;
import com.william.curso.springboot.di.factura.springbootdifactura.models.Product;

@Configuration
@PropertySource(value="classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean
    List<Item> itemsInvoice(){
        return Arrays.asList(new Item(new Product("Cámara Sony",800), 2), new Item(new Product("Bicicleta Bianchi",1200), 4));
    }

    @Bean("default")
    List<Item> itemsInvoiceOffice(){
        Product p1 = new Product("Monitor Asus", 700);
        Product p2 = new Product("Notebook Razer", 2400);
        Product p3 = new Product("Impresora Hp", 800);
        Product p4 = new Product("Escritorio oficina", 900);
        return Arrays.asList(new Item(p1, 4), new Item(p2, 6), new Item(p3, 1), new Item(p4, 4));
    }
}
