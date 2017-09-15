package com.exams.rectangle.json;

/**
 * Created by rodicad on 15/09/2017.
 */
public class JSONWriter {

//    public void buildJSON(Map<Integer, Rectangle> inputRectangles, Map<Integer, Rectangle> outputRectangles ) {
//        JsonWriter jsonWriter = null;
//
//
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
//        mapper.configure( SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
//        mapper.setPropertyNamingStrategy( new PropertyNamingStrategy() {
//            @Override
//            public String nameForField( MapperConfig<?> config, AnnotatedField field, String defaultName ) {
//                if ( field.getFullName().equals( "com.studytrails.json.jackson.Artist#name" ) )
//                    return "Artist-Name";
//                return super.nameForField( config, field, defaultName );
//            }
//
//            @Override
//            public String nameForGetterMethod( MapperConfig<?> config, AnnotatedMethod method, String defaultName ) {
//                if ( method.getAnnotated().getDeclaringClass().equals( Album.class ) && defaultName.equals( "title" ) )
//                    return "Album-Title";
//                return super.nameForGetterMethod( config, method, defaultName );
//            }
//        } )
//        mapper.setSerializationInclusion(Include.NON_EMPTY);
//        mapper.writeValue(System.out, album);
//    }
//
//    }
}
