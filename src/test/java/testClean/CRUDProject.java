package testClean;

import pages.OpcionesDeCuenta;
import pages.OperacionesProyecto;
import pages.PaginaInicio;
import pages.PaginaLogin;
import pages.PaginaPrincipal;
import pages.VentanaEmergenteCreacionYEdicionDeProyecto;
import pages.VentanaEmergenteEliminarProyecto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singleton.Session;


public class CRUDProject extends BaseTodoist{

	PaginaInicio paginaInicio = new PaginaInicio();
    PaginaLogin paginaLogin = new PaginaLogin();
    PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
    OpcionesDeCuenta opcionesCuenta = new OpcionesDeCuenta();
    VentanaEmergenteCreacionYEdicionDeProyecto ventanaEmergenteCreacionYEdicionDeProyecto = new VentanaEmergenteCreacionYEdicionDeProyecto();
    VentanaEmergenteEliminarProyecto ventanaEmergenteEliminarProyecto = new VentanaEmergenteEliminarProyecto();
    OperacionesProyecto operacionesProyecto = new OperacionesProyecto();
    
    @Test
    public void verify_login_todoly() throws InterruptedException {
        //Login
        paginaInicio.buttonLogin.click();
        paginaLogin.emailTextBox.clearSetText("ignacio.valencia.sauma@gmail.com");
        paginaLogin.passwordTextBox.clearSetText("Secreta123");
        paginaLogin.botonIniciarSesion.click();
        //paginaPrincipal.configurationButton.click();

        //Assertions.assertTrue(opcionesCuenta.logoutButton.isControlDisplayed());

        //Crear nuevo proyecto
        
        String nameProyect = "Prueba";
        
        paginaPrincipal.projectButton.click();
        paginaPrincipal.buttonAddProject.click();
        ventanaEmergenteCreacionYEdicionDeProyecto.textBoxNombreProyecto.setText(nameProyect);
        ventanaEmergenteCreacionYEdicionDeProyecto.buttonGuardar.click();
        String actualresult = paginaPrincipal.tituloDeProyecto.getTextControl();
        Thread.sleep(2000);
        Assertions.assertEquals(nameProyect, actualresult, "Error, no se añadio un nuevo proyecto");

        //Update el nombre de un proyecto
        String nameProjectUpdate= "Prueba 123";
        paginaPrincipal.buttonMasOpciones.click();
        operacionesProyecto.buttonEditar.click();
        ventanaEmergenteCreacionYEdicionDeProyecto.textBoxNombreProyecto.clearSetText(nameProjectUpdate);
        ventanaEmergenteCreacionYEdicionDeProyecto.buttonGuardar.click();
        actualresult = paginaPrincipal.tituloDeProyecto.getTextControl();
        Thread.sleep(2000);
        Assertions.assertEquals(nameProjectUpdate, actualresult, "Error, no se cambio el nombre del proyecto");

        //Delete project
        paginaPrincipal.buttonMasOpciones.click();
        operacionesProyecto.buttonEliminar.click();
        ventanaEmergenteEliminarProyecto.buttonEliminarConfirmacion.click();
        Thread.sleep(2000);
        Assertions.assertTrue(!nameProjectUpdate.equals(paginaPrincipal.tituloDeProyecto.getTextControl()));
    }
	
	
}
