package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceInter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "Product", value = "/products")
public class ProductServlet extends HttpServlet {

    ProductServiceInter productService = new ProductService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "find":
                showProductPage(request,response);
                break;
            default:
                showListProduct(request, response);
                break;
        }
    }

    private void showProductPage(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/findProduct.jsp");
        dispatcher.forward(request,response);

    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("thisP",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/delete.jsp");
        dispatcher.forward(request,response);
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Product> productList = productService.findAll();
        request.setAttribute("pList", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/listProduct.jsp");
        requestDispatcher.forward(request, response);
    }


    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "find":
                showProductByName(request,response);
                break;
            default:
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/delete.jsp");
        request.setAttribute("message", "Delete Product Succesfully !!!");
        requestDispatcher.forward(request, response);
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        double cost = Double.parseDouble(request.getParameter("cost"));
        Product product = new Product(id, name, brand, cost);
        productService.editProduct(id, product);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
        request.setAttribute("message", "Edit Product Succesfully !!!");
        requestDispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        double cost = Double.parseDouble(request.getParameter("cost"));
        int id = (int) (Math.random() * 100);
        Product product = new Product(id, name, brand, cost);
        productService.addProduct(product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message", "Create Product Succesfully !!!");
        dispatcher.forward(request, response);
    }

    private void showProductByName(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        List<Product> productList = productService.findAll();
        String name = request.getParameter("findname");
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equalsIgnoreCase(name)){
                Product product = productList.get(i);
                request.setAttribute("namePro",product);
            }
            else {
                request.setAttribute("message","Not Found");
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/findProduct.jsp");
        dispatcher.forward(request,response);
    }
}
