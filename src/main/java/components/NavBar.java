package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import settings.BasePage;

import java.util.ArrayList;
import java.util.List;

public class NavBar extends BasePage {

    @FindBy(id = "foryou_tab")//pestaña tu tienda
    private WebElement yourStoreTab;

    @FindBy(id = "genre_tab")//pestaña juegos
    private WebElement yourGameTab;

    @FindBy(id = "store_nav_search_term")//buscador de palabras
    private WebElement searchTheStoreInput;

    @FindBy(css = "#search_suggestion_contents > a > .match_name")//resultados de busqueda
    private List<WebElement> suggestedGames;

    //locator to search the game Portal2
    @FindBy(css = "#search_suggestion_contents > a[href='https://store.steampowered.com/app/620/Portal_2/?snr=1_7_15__13']")
    private WebElement yourGame;
    //Locator to find the text and use it to check
    @FindBy(className = "apphub_AppName")
    private WebElement titulo;
    //Locator to search the game Age of empires
    @FindBy(css = "#search_suggestion_contents > a[href='https://store.steampowered.com/app/813780/Age_of_Empires_II_Definitive_Edition/?snr=1_7_15__13']")
    private WebElement AgeofEmpires;
//locator in gender
    @FindBy(css = "div.details_block>a")
    private List<WebElement> gender;
//locator in staff
    @FindBy(css = "div.dev_row>a")
    private List<WebElement> developerStaff;

    @FindBy(css = "div.dev_row>a")
    private List<WebElement> finfields;

    @FindBy(linkText = "iniciar sesión")
    private WebElement sesion;

    @FindBy(linkText = "SOPORTE")
    private WebElement suport;

    public NavBar(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openYourStoreTab(){
        this.openNavBarTab(yourStoreTab);
    }

    public void openGamesTab(){
        this.openNavBarTab(yourGameTab);
    }

    public ArrayList<String> getSuggestedGames(){

        ArrayList<String> suggested_games_names = new ArrayList<String>();
        for (WebElement suggestedGame : suggestedGames)
        {
            suggested_games_names.add(suggestedGame.getText());
        }
        return suggested_games_names;
    }

//Get Gender
    public String textGender(){
        return this.getText(gender.get(0));
    }
    public String textStaff1(){//Get the first Staff
        return this.getText(developerStaff.get(0));
    }
    public String textStaff2(){
        return this.getText(developerStaff.get(1));
    }
    public String textStaff3(){
        return this.getText(developerStaff.get(2));
    }
    public String textEditor(){
        return this.getText(finfields.get(3));
    }
    //public String textFranqui(){ return this.getText(finfields.get(5)); }

    public void writeGameIntoSearchInput(String game_name){//buscar juego
        this.writeInInput(searchTheStoreInput, game_name);
    }

    public void writeNewGame(String new_Game){
        this.typeInSerch(searchTheStoreInput,new_Game);
    }

    public void selectYourGame(){//click en juego seleccionado
        this.click(yourGame);
    }

    public void selectYourGame2(){//click en juego seleccionado
        this.click(AgeofEmpires);
    }
// Get text of the Classname: apphub_AppName
   public String grandAccess(){
         return this.getText(titulo); }

    private void openNavBarTab(WebElement tab){
        this.hoverElement(tab);
        String is_active = tab.getAttribute("class");
        Assert.assertTrue(is_active.indexOf("focus") > 0, "The Menu did not open");
    }
     public void selecLinksesion(){this.click(sesion);}
     public void suportClick(){this.click(suport);}
}
