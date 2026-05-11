package catcafe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatCafeTest {

    @Test
    void givenEmptyCafe_whenAddCat_thenCatCountIncreases() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Milo", 5);

        // when
        cafe.addCat(cat);

        // then
        assertEquals(1, cafe.getCatCount());
    }

    @Test
    void givenEmptyCafe_whenGetCatCount_thenReturnZero() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        long count = cafe.getCatCount();

        // then
        assertEquals(0, count);
    }

    @Test
    void givenCatExists_whenGetCatByName_thenReturnCat() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Luna", 4);
        cafe.addCat(cat);

        // when
        FelineOverLord result = cafe.getCatByName("Luna");

        // then
        assertEquals(cat, result);
    }

    @Test
    void givenUnknownName_whenGetCatByName_thenReturnNull() {
        // given
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Milo", 5));

        // when
        FelineOverLord result = cafe.getCatByName("Ghost");

        // then
        assertNull(result);
    }

    @Test
    void givenNullName_whenGetCatByName_thenReturnNull() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        FelineOverLord result = cafe.getCatByName(null);

        // then
        assertNull(result);
    }

    @Test
    void givenCatInWeightRange_whenGetCatByWeight_thenReturnCat() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Chunky", 10);
        cafe.addCat(cat);

        // when
        FelineOverLord result = cafe.getCatByWeight(5, 15);

        // then
        assertEquals(cat, result);
    }

    @Test
    void givenNoCatInWeightRange_whenGetCatByWeight_thenReturnNull() {
        // given
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Tiny", 2));

        // when
        FelineOverLord result = cafe.getCatByWeight(5, 10);

        // then
        assertNull(result);
    }

    @Test
    void givenInvalidWeightRange_whenGetCatByWeight_thenReturnNull() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        FelineOverLord result1 = cafe.getCatByWeight(-1, 5);
        FelineOverLord result2 = cafe.getCatByWeight(10, 5);

        // then
        assertNull(result1);
        assertNull(result2);
    }

    @Test
    void givenMultipleCats_whenGetCatCount_thenReturnCorrectCount() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        cafe.addCat(new FelineOverLord("A", 1));
        cafe.addCat(new FelineOverLord("B", 2));
        cafe.addCat(new FelineOverLord("C", 3));

        // then
        assertEquals(3, cafe.getCatCount());
    }
}
