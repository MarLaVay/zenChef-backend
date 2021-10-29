INSERT INTO public.chef(
    id, email, firstname, name, password)
VALUES (?, ?, ?, ?, ?);

INSERT INTO public.ingredient(
    id, name)
VALUES (?, ?);

INSERT INTO public.quantity(
    id, measuring_unit, "number", ingredient_id, recipe_id)
VALUES (?, ?, ?, ?, ?);

INSERT INTO public.recipe(
    id, method, title, chef_id)
VALUES (?, ?, ?, ?);