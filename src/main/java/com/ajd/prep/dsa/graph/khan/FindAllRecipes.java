package com.ajd.prep.dsa.graph.khan;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class FindAllRecipes {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> supplySet = new HashSet<>();
        supplySet.addAll(Arrays.asList(supplies));

        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, List<String>> recipeIngredients = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        for(int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            graph.put(recipe, new HashSet<>());
            recipeIngredients.put(recipe, ingredients.get(i));
            indegree.put(recipe, 0);
        }


        for(int i = 0; i < recipes.length; i++) {
            List<String> ingredientList = ingredients.get(i);
            String recipe = recipes[i];

            for(String ingredient : ingredientList) {
                if(recipeIngredients.containsKey(ingredient)) {
                    graph.get(ingredient).add(recipe);
                    int tmp = indegree.get(recipe);
                    indegree.put(recipe, tmp+1);
                }
            }
        }

        log.info("indegree: {}", indegree);
        log.info("graph: {}", graph);

        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        for(String recipe : recipes) {
            if(indegree.get(recipe) == 0) {
                q.add(recipe);
            }
        }

        // Set<String> visited = new HashSet<>();
        outer: while(!q.isEmpty()) {
            String recipe = q.remove();

            for(String recipeIngredient : recipeIngredients.get(recipe)) {
                if(!supplySet.contains(recipeIngredient)) {
                    continue outer;
                }
            }
            res.add(recipe);
            supplySet.add(recipe);

            for(String neigh : graph.get(recipe)) {
                int tmp = indegree.get(neigh);
                indegree.put(neigh, tmp-1);

                if(tmp == 1) {
                    q.add(neigh);
                }
            }
        }

        return res;
    }
}
