package com.william.curso.springboot.di.factura.springbootdifactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
public class Invoice {

    @Autowired  //client también es un componente y por lo tanto se puede hacer esto
    private Client client;

    @Value("${invoice.description.office}")
    private String description;

    @Autowired
    @Qualifier("default")
    private List<Item> items;

    @PostConstruct
    public void init(){
        description = description.concat(" del cliente: ").concat(client.getName()).concat(" ").concat(client.getLastname());
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destruyendo el componente invoice");
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    public int getTotal(){
        return items.stream().
        map(item -> item.getImporte()).
        reduce(0,(sum, importe) -> sum + importe);  //sum se define como el iterador
    }

    
}
