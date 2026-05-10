package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CatCafeTest {

    @Test
    void shouldCreateEmptyCafe() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        long amountOfCats = cafe.getCatCount();

        // then
        assertEquals(0, amountOfCats);
    }

    @Test
    void shouldIncreaseCatCountWhenAddingOneCat() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Milo", 4);

        // when
        cafe.addCat(cat);

        // then
        assertEquals(1, cafe.getCatCount());
    }

    @Test
    void shouldIncreaseCatCountWhenAddingMultipleCats() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        cafe.addCat(new FelineOverLord("Milo", 4));
        cafe.addCat(new FelineOverLord("Luna", 3));
        cafe.addCat(new FelineOverLord("Simba", 5));

        // then
        assertEquals(3, cafe.getCatCount());
    }

    @Test
    void shouldFindExistingCatByName() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Luna", 3);
        cafe.addCat(cat);

        // when
        FelineOverLord result = cafe.getCatByName("Luna");

        // then
        assertEquals(cat, result);
    }

    @Test
    void shouldReturnNullWhenCatNameDoesNotExist() {
        // given
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Milo", 4));

        // when
        FelineOverLord result = cafe.getCatByName("Unknown");

        // then
        assertNull(result);
    }

    @Test
    void shouldReturnNullWhenSearchingNameInEmptyCafe() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        FelineOverLord result = cafe.getCatByName("Milo");

        // then
        assertNull(result);
    }

    @Test
    void shouldReturnNullWhenSearchingWithNullName() {
        // given
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Milo", 4));

        // when
        FelineOverLord result = cafe.getCatByName(null);

        // then
        assertNull(result);
    }

    @Test
    void shouldFindCatInsideWeightRange() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Tiger", 4);
        cafe.addCat(cat);

        // when
        FelineOverLord result = cafe.getCatByWeight(3, 5);

        // then
        assertEquals(cat, result);
    }

    @Test
    void shouldFindCatAtLowerWeightBoundary() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Gwen", 3);
        cafe.addCat(cat);

        // when
        FelineOverLord result = cafe.getCatByWeight(3, 5);

        // then
        assertEquals(cat, result);
    }

    @Test
    void shouldReturnNullWhenNoCatIsInsideWeightRange() {
        // given
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Tiny", 2));

        // when
        FelineOverLord result = cafe.getCatByWeight(3, 5);

        // then
        assertNull(result);
    }

    @Test
    void shouldReturnNullWhenWeightRangeIsInvalid() {
        // given
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Milo", 4));

        // when
        FelineOverLord result = cafe.getCatByWeight(5, 3);

        // then
        assertNull(result);
    }
}
