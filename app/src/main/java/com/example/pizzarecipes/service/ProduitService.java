package com.example.pizzarecipes.service;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.dao.IDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    private static ProduitService INSTANCE;
    private final List<Produit> data = new ArrayList<>();

    private ProduitService() {
        seed();
    }

    public static ProduitService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ProduitService();
        }
        return INSTANCE;
    }

    private void seed() {

        create(new Produit("BARBECUED CHICKEN PIZZA",3,R.drawable.pizza1,"35 min",
                "- Chicken\n- Barbecue sauce\n- Cheese",
                "Pizza au poulet barbecue très savoureuse.",
                "STEP 1: Griller le poulet.\nSTEP 2: Ajouter la sauce.\nSTEP 3: Cuire la pizza."));

        create(new Produit("BRUSCHETTA PIZZA",5,R.drawable.pizza2,"35 min",
                "- Sausage\n- Pepperoni\n- Mozzarella\n- Tomatoes",
                "Pizza italienne riche en saveurs.",
                "STEP 1: Cuire la viande.\nSTEP 2: Ajouter sur la pâte.\nSTEP 3: Cuire au four."));

        create(new Produit("SPINACH PIZZA",2,R.drawable.pizza3,"25 min",
                "- Spinach\n- Tomatoes\n- Alfredo sauce",
                "Pizza végétarienne simple et délicieuse.",
                "STEP 1: Préparer la pâte.\nSTEP 2: Ajouter les légumes.\nSTEP 3: Cuire."));

        create(new Produit("DEEP-DISH SAUSAGE PIZZA",8,R.drawable.pizza4,"45 min",
                "- Sausage\n- Flour\n- Herbs",
                "Pizza épaisse style Chicago.",
                "STEP 1: Préparer la pâte.\nSTEP 2: Ajouter les couches.\nSTEP 3: Cuire."));

        create(new Produit("HOMEMADE PIZZA",4,R.drawable.pizza5,"50 min",
                "- Dough\n- Tomato sauce\n- Cheese",
                "Pizza maison classique.",
                "STEP 1: Préparer la pâte.\nSTEP 2: Ajouter les ingrédients.\nSTEP 3: Cuire."));

        create(new Produit("PESTO CHICKEN PIZZA",3,R.drawable.pizza6,"50 min",
                "- Chicken\n- Pesto\n- Mozzarella",
                "Pizza au poulet et pesto.",
                "STEP 1: Cuire le poulet.\nSTEP 2: Ajouter le pesto.\nSTEP 3: Cuire la pizza."));

        create(new Produit("LOADED MEXICAN PIZZA",3,R.drawable.pizza7,"30 min",
                "- Black beans\n- Tomatoes\n- Cheese",
                "Pizza mexicaine épicée.",
                "STEP 1: Préparer les ingrédients.\nSTEP 2: Ajouter sur la pâte.\nSTEP 3: Cuire."));

        create(new Produit("BACON CHEESEBURGER PIZZA",2,R.drawable.pizza8,"20 min",
                "- Beef\n- Bacon\n- Cheese",
                "Pizza inspirée du cheeseburger.",
                "STEP 1: Cuire la viande.\nSTEP 2: Ajouter le bacon.\nSTEP 3: Cuire."));

        create(new Produit("PIZZA MARGHERITA",1,R.drawable.pizza9,"30 min",
                "- Tomato\n- Mozzarella\n- Basil",
                "Pizza italienne classique.",
                "STEP 1: Ajouter la sauce tomate.\nSTEP 2: Ajouter le fromage.\nSTEP 3: Cuire."));

        create(new Produit("PEPPERONI SAUSAGE PIZZA",5,R.drawable.pizza10,"45 min",
                "- Pepperoni\n- Sausage\n- Cheese",
                "Pizza riche en viande.",
                "STEP 1: Préparer la pâte.\nSTEP 2: Ajouter les viandes.\nSTEP 3: Cuire."));
    }

    @Override
    public Produit create(Produit p) {
        data.add(p);
        return p;
    }

    @Override
    public Produit update(Produit p) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == p.getId()) {
                data.set(i, p);
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        return data.removeIf(p -> p.getId() == id);
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : data) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return Collections.unmodifiableList(data);
    }
}