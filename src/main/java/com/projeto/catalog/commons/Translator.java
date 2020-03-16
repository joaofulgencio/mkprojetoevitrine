package com.projeto.catalog.commons;


import com.projeto.catalog.exception.TranslateException;
import org.modelmapper.ModelMapper;

public class Translator {
    private Translator() throws TranslateException {
        throw new TranslateException("Do not instantiate static method");
    }

    public static <I, O> O translate(I source, Class<O> outClass) {
        return (new ModelMapper()).map(source, outClass);
    }
}

