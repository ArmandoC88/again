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
    @Test(priority = 2)//game Portal 2
    public void selectGamePortal_2(){
        navBar.selectYourGame();
        String A = "Portal 2";
        String B = navBar.grandAccess();
        if (A == B){
            System.out.println("Your game selected is:"+ B);
        }else{
        System.out.println("the game was not found");}
    }
   @Test(groups = "game2")//Game age of empires
    public void newGame(){
        String new_Game = "Age";
        navBar.writeNewGame(new_Game);
        navBar.selectYourGame2();
        String titulo =navBar.grandAccess();
        String Genero = navBar.textGender();
   //Developers staff
        String Des1= navBar.textStaff1();
        String Des2  =navBar.textStaff2();
        String Des3 = navBar.textStaff3();
        String Editor = navBar.textEditor();
  System.out.println("data of the  game:"+titulo+","+ Genero+","+Des1+","+Des2+","+Des3+Editor);
       navBar.openYourStoreTab();
   }
   @Test(groups = "bottonsesion")
    public void selectlinksesion(){
        navBar.selecLinksesion();
   }
   @Test(groups = "suport")
    public void selectSuportlink(){navBar.suportClick();}
}

