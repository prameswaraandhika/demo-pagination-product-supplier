package com.prameswaradev.crud_demo_product_supplier.controller;

import com.prameswaradev.crud_demo_product_supplier.dto.BrandDtoNew;
import com.prameswaradev.crud_demo_product_supplier.dto.BrandSupplierDto;
import com.prameswaradev.crud_demo_product_supplier.entity.Brand;
import com.prameswaradev.crud_demo_product_supplier.mapper.BrandMapper;
import com.prameswaradev.crud_demo_product_supplier.repository.BrandRepository;
import com.prameswaradev.crud_demo_product_supplier.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;
    private final BrandRepository brandRepository;

    @GetMapping("/brands")
    public String listBrands(Model model,
                             @RequestParam(required = false) String keyword,
                             @RequestParam(defaultValue = "1") int page,
                             @RequestParam(defaultValue = "3") int size){
        try {
            List<BrandSupplierDto> brands;
            Pageable paging = PageRequest.of(page - 1, size);
            Page<BrandSupplierDto> pagesBrands = brandService.findAllBrands(paging);
            if (keyword != null){
                pagesBrands = brandRepository.findByName(keyword, paging);
                model.addAttribute("keyword", keyword);
            }
            brands = pagesBrands.getContent();
            model.addAttribute("brands", brands);
            model.addAttribute("currentPage", pagesBrands.getNumber() + 1);
            model.addAttribute("totalItems", pagesBrands.getTotalElements());
            model.addAttribute("totalPages", pagesBrands.getTotalPages());
            model.addAttribute("pageSize", size);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "list-brand";
    }

    @PostMapping("/brands/save")
    public String savebrand(Brand brand, RedirectAttributes redirectAttributes) {
        try {
//            brandService.createBrand(brand);

            redirectAttributes.addFlashAttribute("message", "The brand has been saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addAttribute("message", e.getMessage());
        }

        return "redirect:/brands";
    }

    @GetMapping("/brands/{id}")
    public String editbrand(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
//            Brand brand = brandService.findById(id).get();

//            model.addAttribute("brand", brand);
            model.addAttribute("pageTitle", "Edit brand (ID: " + id + ")");

            return "brand_form";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());

            return "redirect:/brands";
        }
    }

    @GetMapping("/brands/delete/{id}")
    public String deletebrand(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
//            brandService.deleteById(id);

            redirectAttributes.addFlashAttribute("message", "The brand with id=" + id + " has been deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }

        return "redirect:/brands";
    }
}
