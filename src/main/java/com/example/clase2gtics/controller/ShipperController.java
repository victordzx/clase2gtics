package com.example.clase2gtics.controller;

import com.example.clase2gtics.entity.Shipper;
import com.example.clase2gtics.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shipper")
public class ShipperController {

    @Autowired
    ShipperRepository shipperRepository;

    @GetMapping("/listar")
    public String listarTransportistas(Model model) {
        List<Shipper> shipperList = shipperRepository.findAll();
        model.addAttribute("shipperList", shipperList);
        return "shipper/lista";
    }

    @GetMapping("/newform")
    public String newform() {
        return "shipper/newForm";
    }

    @PostMapping("/save")
    public String saveShip(Shipper shipper) {
        shipperRepository.save(shipper);
        return "redirect:/shipper/listar";
    }

    @PostMapping("/update")
    public String updateShip(Shipper shipperForm) {
        Optional<Shipper> optionalShipper = shipperRepository.findById(shipperForm.getShipperid());
        if (optionalShipper.isPresent()) {
            Shipper shipperFromDb = optionalShipper.get();
            shipperFromDb.setCompanyname(shipperForm.getCompanyname());
            shipperRepository.save(shipperFromDb);
        }
        return "redirect:/shipper/listar";
    }

    @GetMapping("/editar")
    public String editarForm(@RequestParam("id") int id, Model model) {
        Optional<Shipper> optionalShipper = shipperRepository.findById(id);
        if (optionalShipper.isPresent()) {
            Shipper shipper = optionalShipper.get();
            model.addAttribute("shipper", shipper);
            return "shipper/editForm";
        } else {
            return "redirect:/shipper/listar";
        }
    }

    @GetMapping("/borrar")
    public String borrar(@RequestParam("id") int id) {
        Optional<Shipper> optionalShipper = shipperRepository.findById(id);
        if (optionalShipper.isPresent()) {
            shipperRepository.deleteById(id);
        }
        return "redirect:/shipper/listar";
    }

}
