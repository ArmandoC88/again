package tests;

import components.NavBar;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import settings.BaseTest;

import java.util.ArrayList;

public class HomePageTests extends BaseTest {

    private NavBar navBar;

    @BeforeTest
    public void setUp(){
        navBar = new NavBar(this.driver);
    }

   /* @Test(priority = 0)
    public void openAllNavBarTabs(){
        navBar.openYourStoreTab();
        navBar.openGamesTab();
    }*/

    @Test(priority = 1)
    public void testSuggestedGames(){
        String game_name = "Portal";
        navBar.writeGameIntoSearchInput(game_name);
        ArrayList<String> games = navBar.getSuggestedGames();
        Assert.assertTrue(games.size() == 5, "The number of suggested games is not correct");
        for(String game: games){
            Assert.assertTrue(game.indexOf(game_name) >= 0, "The game " + game + " is not correct. Not contains Search String " + game_name);
        }
    }
    @Test(priority = 2)
    public void selectGamePortal_2(){
       //click and select Portal 2
        navBar.selectYourGame();
        String A = "Portal 2";
        String B = navBar.grandAccess();
        if (A == B){
            System.out.println("Your game selected is:"+ B);
        }else{
        System.out.println("the game was not found");}
        //I try to get the text or select the locator , I need to find another way , i´ve comented this
        //navBar.grandAccess2();
    }
   @Test(priority =3)
    public void newGame(){
        //click and selec Age of empires
        String new_Game = "Age";
        navBar.writeNewGame(new_Game);
        navBar.selectYourGame2();
        String titulo =navBar.grandAccess();
       Assert.assertEquals("Age of Empires II: Definitive Edition",titulo);
        String Genero = navBar.textGender();
       Assert.assertEquals("Estrategia",Genero);
   //Developers staff
        String Des1= navBar.textStaff1();
       Assert.assertEquals("Forgotten Empires", Des1);

        String Des2  =navBar.textStaff2();
        Assert.assertEquals("Tantalus Media",Des2);

        String Des3 = navBar.textStaff3();
        Assert.assertEquals("Wicked Witch",Des3);
        //Editor and franquicia
       String Editor = navBar.textEditor();
       String franq = navBar.textFranqui();
       Assert.assertEquals("Editor",Editor);
       Assert.assertEquals("Franquisia",franq);

   }

}

