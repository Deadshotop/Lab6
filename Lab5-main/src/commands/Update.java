package src.commands;

import src.managers.HashTableManager;
import src.managers.IOManager;
import src.managers.StringManager;
import src.product.Product;


public class Update extends AbstractCommand{
    private IOManager manager;
    private String string = "Id not found";
    public Update(String name, HashTableManager products, IOManager manager, StringManager stringManager) {
        super(name, products, stringManager);
        this.manager = manager;
    }

    @Override
    public void execute() {
        Integer id = manager.getId();
        if (id != null) {
            if (products.findId(id)) {
                Product product = manager.getProduct();
                if (product != null) {
                    product.setId(id);
                    products.insert(products.removeById(id), product);
                }
            } else {
                stringManager.multiLine(string);
            }
        }

    }
}
