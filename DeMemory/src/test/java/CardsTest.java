import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;
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
	private List<Card> mockCards;

	@Mock
	private Image mockImage;

	@Mock
	private Point mockPoint;

	@Mock
	private Graphics mockG;

	@Test
	@DisplayName("Paint Test")
	void paintTest() {

		Card card = new Card(1, 0, this.mockImage);
		Card spyCard = spy(card);
		this.cardsClass.setCards(this.mockCards);
		doReturn(spyCard).when(this.mockCards).get(anyInt());
		this.cardsClass.paint(this.mockG);

		verify(spyCard, times(16)).paint(any(Graphics.class), anyInt(), anyInt());
	}

	@Test
	void getCardsTest(){

		assertEquals(16, this.cardsClass.getCards().size());
	}

	@Test
	void cardClickedTest() {

		//when(this.spyCardsSelected.size()).thenReturn(0);

		Card card1 = new Card(1, 0, this.mockImage);
		Card spyCard = spy(card1);
		List<Card> cards = new ArrayList<>();
		cards.add(spyCard);

		this.cardsClass.setCards(cards);
		this.cardsClass.setCardsSelected(this.spyCardsSelected);
		when(spyCard.isReversed()).thenReturn(true);
		when(spyCard.contains(this.mockPoint)).thenReturn(true);

		this.cardsClass.cardClicked(this.mockPoint);
		verify(this.spyCardsSelected, times(1)).add(spyCard);
		verify(spyCard, times(1)).setReversed(false);
	}

	@Test
	void isSameColorTest() {

		Card card1 = new Card(1, 0, this.mockImage);
		Card card2 = new Card(1, 0, this.mockImage);

		assertTrue(this.cardsClass.isSameColor(card1, card2));

		card2.setColor(1);

		assertFalse(this.cardsClass.isSameColor(card1, card2));

		assertThrows(NullPointerException.class, () -> {

			this.cardsClass.isSameColor(card1, null);
		});
	}

	@Test
	void isFullCardsSelectedTest() {

		this.cardsClass.setCardsSelected(this.spyCardsSelected);
		when(this.spyCardsSelected.size()).thenReturn(2);
		doReturn(true).when(this.cardsClass).isSameColor(any(), any());

		this.cardsClass.isFullCardsSelected();

		assertTrue(this.cardsClass.isCorrect());
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