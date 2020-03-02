import app.controllers.HomeController;
import app.data.Spitter;
import app.services.SpitterService;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class HomeControllerTest {

    @Test
    public void shouldDisplayRecentSpittles() {
        List<Spitter> expectedSpitters = Arrays.asList(new Spitter(), new Spitter(), new Spitter());
        SpitterService spitterService = mock(SpitterService.class);
        when(spitterService.getRecentSpittles(25)).thenReturn(expectedSpitters);
        HomeController homeController = new HomeController(spitterService);
        HashMap<String, Object> model = new HashMap<>();

        String viewName = homeController.showHomePage(model);
        Assert.assertEquals("home", viewName);
        Assert.assertSame(expectedSpitters, model.get("spitters"));
        verify(spitterService).getRecentSpittles(25);
    }

}
