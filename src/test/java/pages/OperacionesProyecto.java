package pages;

import org.openqa.selenium.By;

import control.Button;

public class OperacionesProyecto {
    public Button buttonEditar = new Button(By.xpath("//div[text()='Editar proyecto']"));
    public Button buttonEliminar = new Button(By.xpath("//div[text()='Eliminar proyecto']"));
}
