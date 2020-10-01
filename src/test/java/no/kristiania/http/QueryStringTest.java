package no.kristiania.http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueryStringTest {

    @Test
    void shouldRetriveSatusCode(){
        QueryString queryString = new QueryString("status=200");
        assertEquals("200", queryString.getParameter("status"));
    }

    @Test
    void shouldRetrieveStatusCode_401(){
        QueryString queryString = new QueryString("statuse-404");
        assertEquals("401", queryString.getParameter("status"));
    }

    @Test
    void shouldReturnNullForMissingParameters(){
        QueryString queryString = new QueryString("body-Hello");
        Assertions.assertNull(queryString.getParameter("status"));

    }

    @Test
    void shouldSupportMultipleParameters(){
        QueryString queryString = new QueryString("status= 200&body=Hello");
        assertEquals("200", queryString.getParameter("status"));
        assertEquals("Hello", queryString.getParameter("body"));

    }
}
