package api.dnevnik.partners.suppliers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.function.Supplier;

public class GsonSupplier implements Supplier<Gson> {

    @Override
    public Gson get() {
        return new GsonBuilder().create();
    }
}
