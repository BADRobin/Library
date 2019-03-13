package org.ua.bryl.controller.admin;

import org.ua.bryl.model.Product;
import org.ua.bryl.services.ProductService;
import org.ua.bryl.utils.Product_Category_List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Created by olegbryl 01/08/2018.
 */

@Controller
@RequestMapping("/admin")
public class AdminProductController {


    private Path path;
    private Product_Category_List list_categories = new Product_Category_List();
    @Autowired
    private ProductService productService;

    @RequestMapping("/inventory/add")
    public String productAdd(Model model) {
        Product product = new Product();
//        product.setCondition("New");
        model.addAttribute("category_list", list_categories.categories);
        model.addAttribute(product);

        return "productAdd";
    }

    @RequestMapping(value = "/inventory/add" , method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product,
                                 BindingResult result, HttpServletRequest request, Model model) {
        model.addAttribute("category_list", list_categories.categories);

        if(result.hasErrors()) {
            return "productAdd";
        }
        productService.addProduct(product);
        MultipartFile product_image = product.getImage();
        String root_directory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(root_directory + "\\WEB-INF\\resources\\product_images\\" + product.getProduct_id() + ".png");

        if (product_image != null && !product_image.isEmpty()) {
            try {
                product_image.transferTo(new File(path.toString()));
                /**
                Scale Image to fit ascpect ratio IF NECESSARY...
                //Convert it it to resize it
                // Retrieve Image
                BufferedImage buffer = ImageIO.read(new File(path.toString()));
                int image_type = buffer.getType();
                BufferedImage bufferNew = image_resizer.scale(buffer, image_type, 700, 600, 1.4, 1.4);
                File outputfile = new File(path.toString());
                ImageIO.write(bufferNew, "png", outputfile); // Write the Buffered Image into an output file
                **/
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("The product image could not be saved.\n" + e);
            }
        }
        return "redirect:/admin/inventory";
    }

    @RequestMapping("/inventory/edit/{product_id}")
    public String editProduct(@PathVariable("product_id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("category_list", list_categories.categories);
        model.addAttribute("product", product);

        return "productEdit";
    }

    @RequestMapping(value = "/inventory/edit", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("product") Product product,
                                  BindingResult result, Model model, HttpServletRequest request) throws RuntimeException {
        model.addAttribute("category_list", list_categories.categories);
        if (result.hasErrors()) {
            return "productEdit";
        }
        MultipartFile productImage = product.getImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\product_images\\" + product.getProduct_id() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
                try {
                    productImage.transferTo(new File(path.toString()));
                } catch (Exception e) {
                    throw new RuntimeException("The product image could not be saved.\n" + e);
                }
        }
        productService.editProduct(product);

        return "redirect:/admin/inventory";
    }

    @RequestMapping("/inventory/remove/{product_id}")
    public String deleteProduct(@PathVariable("product_id") int product_id, Model model, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\product_images\\" + product_id + ".png");
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Product product = productService.getProductById(product_id);
        productService.deleteProduct(product);

        return "redirect:/admin/inventory";
    }

}
