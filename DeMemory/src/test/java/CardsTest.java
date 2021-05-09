import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CardsTest {

	@Spy
	private List<Card> spyCardsSelected;

	@Spy
	private Cards cardsClass;

	@Mock
	private Image mockImage;

	@Mock
	private List<Card> mockCards;

	@Test
	@DisplayName("Paint Test")
	void paintTest() {

	}

	@Test
	void cardClickedTest() {

	}

	@Test
	void flipIncorrectCardsTest() {

		this.cardsClass.setCardsSelected(this.spyCardsSelected);
		this.cardsClass.setCorrect(true);
		when(this.spyCardsSelected.size()).thenReturn(2);

		this.cardsClass.flipIncorrectCards();
		verify(this.cardsClass, times(0)).flipSelectedCards();
		verify(this.spyCardsSelected, times(1)).clear();


		this.cardsClass.setCorrect(false);
		this.cardsClass.setContTimeToflip(this.cardsClass.getTimeToFlip());
		doNothing().when(this.cardsClass).flipSelectedCards();

		this.cardsClass.flipIncorrectCards();
		verify(this.cardsClass, times(1)).flipSelectedCards();
		verify(this.spyCardsSelected, times(2)).clear();
	}

	@Test
	void flipSelectedCardsTest() {

		Card card = new Card(1, 0, this.mockImage);
		Card spyCard = spy(card);
		List<Card> cardsList = new ArrayList<>();

		this.cardsClass.setCardsSelected(cardsList);

		this.cardsClass.flipSelectedCards();
		verify(spyCard, times(0)).setReversed(true);

		cardsList.add(spyCard);
		this.cardsClass.flipSelectedCards();
		verify(spyCard, times(1)).setReversed(true);

		cardsList.add(spyCard);
		this.cardsClass.flipSelectedCards();
		verify(spyCard, times(3)).setReversed(true);

		assertThrows(NullPointerException.class, () -> {

			this.cardsClass.setCardsSelected(null);
			this.cardsClass.flipSelectedCards();
		});
	}

}