package jaxrs.converters;

import shared.restModels.Kweet;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;


@Stateless
@Provider
public class KweetParamConverterProvider implements ParamConverterProvider{

    @Inject
    KweetParamConverter kweetParamConverter;

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if(rawType.equals(Kweet.class)){
            return (ParamConverter<T>) kweetParamConverter;
        }
        return null;
    }
}