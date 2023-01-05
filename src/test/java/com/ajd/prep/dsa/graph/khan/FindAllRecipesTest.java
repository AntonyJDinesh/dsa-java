package com.ajd.prep.dsa.graph.khan;

import com.ajd.prep.dsa.graph.misc.MaximalNetworkRank;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class FindAllRecipesTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {
                    new String[]{"bread", "sandwich", "burger"},
                        Arrays.asList(new List[]{Arrays.asList(new String[]{"yeast","flour"}), Arrays.asList(new String[]{"bread","meat"}), Arrays.asList(new String[]{"sandwich","meat","bread"})}),
                        new String[]{"yeast","flour","meat"},
                        Arrays.asList(new String[]{"bread", "sandwich", "burger"})
                },
        });
    }


    private FindAllRecipes findAllRecipes = new FindAllRecipes();
    private List<String> res;

    private String[] recipes, supplies;
    private List<List<String>> ingredients;

    public FindAllRecipesTest(String[] recipes, List<List<String>> ingredients, String[] supplies, List<String> res) {
        this.recipes = recipes;
        this.ingredients = ingredients;
        this.supplies = supplies;
        this.res = res;
    }

    @Test
    public void minReorderTest() {
        List<String> got = findAllRecipes.findAllRecipes(this.recipes, this.ingredients, this.supplies);
        assertEquals(res, got);
    }
}
