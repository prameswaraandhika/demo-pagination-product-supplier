package com.prameswaradev.crud_demo_product_supplier.controller;

import com.prameswaradev.crud_demo_product_supplier.dto.BrandDtoNew;
import com.prameswaradev.crud_demo_product_supplier.dto.BrandSupplierDto;
import com.prameswaradev.crud_demo_product_supplier.entity.Brand;
import com.prameswaradev.crud_demo_product_supplier.mapper.BrandMapper;
import com.prameswaradev.crud_demo_product_supplier.repository.BrandRepository;
import com.prameswaradev.crud_demo_product_supplier.service.BrandService;
import com.prameswaradev.crud_demo_product_supplier.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;
    private final SupplierService supplierService;

    @GetMapping("/brands")
    public String listBrands(Model model,
                             @RequestParam(required = false) String keyword,
                             @RequestParam(defaultValue = "1") int page,
                             @RequestParam(defaultValue = "3") int size){
        try {
            Pageable paging = PageRequest.of(page - 1, size);
            Page<BrandSupplierDto> pagesBrands = getBrands(keyword, paging);
            List<BrandSupplierDto> brands = pagesBrands.getContent();
            model.addAttribute("keyword", keyword);
            model.addAttribute("brands", brands);
            model.addAttribute("currentPage", pagesBrands.getNumber() + 1);
            model.addAttribute("totalItems", pagesBrands.getTotalElements());
            model.addAttribute("totalPages", pagesBrands.getTotalPages());
            model.addAttribute("pageSize", size);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "brands/list-brand";
    }

    private Page<BrandSupplierDto> getBrands(String keyword, Pageable paging) {
        if (keyword != null){
            return brandService.findAllByName(keyword, paging);
        }
        return brandService.findAllBrands(paging);
    }

    @GetMapping("/brands/new")
    public String showFormCreateBrand(Model model){
        var brand = new Brand();
        model.addAttribute("brand", brand);
        return "brands/form-brand";
    }

    @ModelAttribute("suppliers")
    public void loadSuppliers(Model model){
        model.addAttribute("suppliers", supplierService.findAll());
    }


    @PostMapping("/brands/save")
    public String saveBrand(@Valid @ModelAttribute("brand") BrandDtoNew brand,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
            Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("brand", brand);
            return "brands/form-brand";
        }
        brandService.createBrand(brand);
        redirectAttributes.addFlashAttribute("message", "The brand has been saved successfully!");
        return "redirect:/brands";
    }



    @GetMapping("/brands/{id}")
    public String showFormEditBrand(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttributes) {
        try {
            var brand = brandService.getBrandById(id);
            model.addAttribute("brand", brand);
            return "brands/form-brand";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/brands";
        }
    }

    @GetMapping("/brands/delete/{id}")
    public String deleteBrand(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        try {
            var brandDelete = brandService.getBrandById(id);
            brandService.deleteBrandById(id);
            redirectAttributes.addFlashAttribute("message", String.format("%s has been deleted.", brandDelete));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/brands";
    }
}
