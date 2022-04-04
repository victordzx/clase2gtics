package com.example.clase2gtics.controller;

import com.example.clase2gtics.entity.Region;
import com.example.clase2gtics.entity.Shipper;
import com.example.clase2gtics.entity.Territory;
import com.example.clase2gtics.repository.RegionRepository;
import com.example.clase2gtics.repository.TerritoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/territory")
public class TerritoryController {

    @Autowired TerritoryRepository territoryRepository;
    @Autowired RegionRepository regionRepository;

    @GetMapping("/listar")
    public String listarTerritorios(Model model) {
        List<Territory> territoryList = territoryRepository.findAll();
        model.addAttribute("territoryList", territoryList);
        return "territory/lista";
    }

    @GetMapping("/newform")
    public String newform(Model model) {
        List<Region> regionList = regionRepository.findAll();
        model.addAttribute("regionList", regionList);
        return "territory/newForm";
    }

    @PostMapping("/save")
    public String saveShip(Territory territory) {
        territoryRepository.save(territory);
        return "redirect:/territory/listar";
    }

    @PostMapping("/update")
    public String updateShip(Territory territoryForm) {
        Optional<Territory> optionalTerritory = territoryRepository.findById(territoryForm.getId());
        if (optionalTerritory.isPresent()) {
            Territory territoryFromDb = optionalTerritory.get();
            territoryFromDb.setTerritoryDescription(territoryForm.getTerritoryDescription());
            territoryFromDb.setRegionID(territoryForm.getRegionID());
            territoryRepository.save(territoryFromDb);
        }
        return "redirect:/territory/listar";
    }

    @GetMapping("/editar")
    public String editarForm(@RequestParam("id") String id, Model model) {
        Optional<Territory> optionalTerritory = territoryRepository.findById(id);

        List<Region> regionList = regionRepository.findAll();
        model.addAttribute("regionList", regionList);

        if (optionalTerritory.isPresent()) {
            Territory territory = optionalTerritory.get();
            model.addAttribute("territory", territory);
            return "territory/editForm";
        } else {
            return "redirect:/territory/listar";
        }
    }

}
