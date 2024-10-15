package api.dnevnik.partners.suppliers;

import api.dnevnik.partners.network.deserializers.LocalDateDeserializer;
import api.dnevnik.partners.network.deserializers.LocalDateTimeDeserializer;
import api.dnevnik.partners.network.deserializers.OffsetDateTimeTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.function.Supplier;

public class GsonSupplier implements Supplier<Gson> {

    @Override
    public Gson get() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
                .registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeTypeAdapter()).create();
    }
}
