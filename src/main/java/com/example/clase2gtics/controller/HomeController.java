package com.example.clase2gtics.controller;

import com.example.clase2gtics.entity.Alumno;
import com.example.clase2gtics.entity.Carro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping("/vsimples")
    public String vsimples(Model model) {

        Alumno alumno = new Alumno("Juan Perez", 20064452);
        model.addAttribute("Campus", "PUCP");
        model.addAttribute("alumno", alumno);
        model.addAttribute("texto","Este es un texto");
        model.addAttribute("número",50);
        return "ejemplo1";
    }

    @GetMapping("/llenarForm")
    public String llenarForm(Model model) {

        Carro carro = new Carro("ABC123", "rojo", "Nissan", 2017);
        model.addAttribute("carro", carro);
        return "ejemplo2";
    }

    @GetMapping("/iterarLista")
    public String iterarLista(Model model) {

        ArrayList<Alumno> lista = new ArrayList<>();
        lista.add(new Alumno("Juan", 3333));
        lista.add(new Alumno("Pedro", 6666));
        lista.add(new Alumno("David", 9999));
        lista.add(new Alumno("Carlos", 2222));
        model.addAttribute("lista", lista);
        return "ejemplo3";
    }

    @GetMapping("/llenarCombo")
    public String llenarCombo(Model model) {

        ArrayList<Carro> listaCarros = new ArrayList<>();
        listaCarros.add(new Carro("Nissan"));
        listaCarros.add(new Carro("Toyota"));
        listaCarros.add(new Carro("Chery"));
        listaCarros.add(new Carro("Honda"));
        model.addAttribute("listaCarros", listaCarros);
        return "ejemplo4";
    }

    @GetMapping("/condicionales")
    public String condicionales(Model model) {

        int x = 1;
        model.addAttribute("x", x);
        String y = "si";
        model.addAttribute("y",y);

        ArrayList<Carro> listaNissan = new ArrayList<>();
        listaNissan.add(new Carro("Nissan", "QWE123", "rojo"));
        listaNissan.add(new Carro("Nissan", "ERT456", "verde"));

        ArrayList<Carro> listaToyota = new ArrayList<>();
        listaToyota.add(new Carro("Toyota", "RTY567", "azul"));
        listaToyota.add(new Carro("Toyota", "FGH789", "amarillo"));

        model.addAttribute("listaNissan", listaNissan);
        model.addAttribute("listaToyota", listaToyota);
        return "ejemplo5";
    }

    @GetMapping("/ejemDataBindForm")
    public String ejemDataBindForm(Model model) {
        model.addAttribute("alumno", new Alumno("Agustín",20202020,new Carro("Toyota")));
        return "ejemploDataBinding";
    }

    @PostMapping("/ejemDataBind")
    public String ejemDataBind(Alumno alumno,@RequestParam("info") String info) {

        System.out.println("Nombre del alumno: " + alumno.getNombre());
        System.out.println("Código del alumno: " + alumno.getCodigo());
        System.out.println("carro marca: " + alumno.getCarro().getMarca());
        System.out.println("carro color: " + alumno.getCarro().getColor());
        System.out.println("info: " + info);
        return "redirect:/";
    }

}
