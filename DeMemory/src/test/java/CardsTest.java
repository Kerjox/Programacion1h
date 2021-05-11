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
	private Cards spyCardsClass;

	@Mock
	private List<Card> mockCards;

	@Mock
	private Image mockImage;

	@Mock
	private Point mockPoint;

	@Mock
	private Graphics mockG;

	@Test
	@DisplayName("Paint")
	void paintTest() {

		Card card = new Card(1, 0, this.mockImage);
		Card spyCard = spy(card);
		this.spyCardsClass.setCards(this.mockCards);
		doReturn(spyCard).when(this.mockCards).get(anyInt());
		this.spyCardsClass.paint(this.mockG);

		verify(spyCard, times(16)).paint(any(Graphics.class), anyInt(), anyInt());
	}

	@Test
	@DisplayName("Get Cards")
	void getCardsTest() {

		assertEquals(16, this.spyCardsClass.getCards().size());
	}

	@Test
	@DisplayName("Card Clicked")
	void cardClickedTest() {

		//when(this.spyCardsSelected.size()).thenReturn(0);

		Card card1 = new Card(1, 0, this.mockImage);
		Card spyCard = spy(card1);
		List<Card> cards = new ArrayList<>();
		cards.add(spyCard);

		this.spyCardsClass.setCards(cards);
		this.spyCardsClass.setCardsSelected(this.spyCardsSelected);
		when(spyCard.isReversed()).thenReturn(true);
		when(spyCard.contains(this.mockPoint)).thenReturn(true);

		this.spyCardsClass.cardClicked(this.mockPoint);
		verify(this.spyCardsSelected, times(1)).add(spyCard);
		verify(spyCard, times(1)).setReversed(false);
	}

	@Test
	@DisplayName("Is Same Color?")
	void isSameColorTest() {

		Card card1 = new Card(1, 0, this.mockImage);
		Card card2 = new Card(1, 0, this.mockImage);

		assertTrue(this.spyCardsClass.isSameColor(card1, card2));

		card2.setColor(1);

		assertFalse(this.spyCardsClass.isSameColor(card1, card2));

		assertThrows(NullPointerException.class, () -> {

			this.spyCardsClass.isSameColor(card1, null);
		});
	}

	@Test
	@DisplayName("Are All Cards Selected?")
	void areAllCardsSelectedTest() {

		this.spyCardsClass.setCardsSelected(this.spyCardsSelected);
		when(this.spyCardsSelected.size()).thenReturn(2);
		doReturn(true).when(this.spyCardsClass).isSameColor(any(), any());

		this.spyCardsClass.areAllCardsSelected();

		assertTrue(this.spyCardsClass.isCorrect());
	}

	@Test
	@DisplayName("Flip Incorrect Cards")
	void flipIncorrectCardsTest() {

		this.spyCardsClass.setCardsSelected(this.spyCardsSelected);
		this.spyCardsClass.setCorrect(true);
		when(this.spyCardsSelected.size()).thenReturn(2);

		this.spyCardsClass.flipIncorrectCards();
		verify(this.spyCardsClass, times(0)).flipSelectedCards();
		verify(this.spyCardsSelected, times(1)).clear();


		this.spyCardsClass.setCorrect(false);
		this.spyCardsClass.setContTimeToFlip(this.spyCardsClass.getTimeToFlip());
		doNothing().when(this.spyCardsClass).flipSelectedCards();

		this.spyCardsClass.flipIncorrectCards();
		verify(this.spyCardsClass, times(1)).flipSelectedCards();
		verify(this.spyCardsSelected, times(2)).clear();
	}

	@Test
	@DisplayName("Flip Selected Cards")
	void flipSelectedCardsTest() {

		Card card = new Card(1, 0, this.mockImage);
		Card spyCard = spy(card);
		List<Card> cardsList = new ArrayList<>();

		this.spyCardsClass.setCardsSelected(cardsList);

		this.spyCardsClass.flipSelectedCards();
		verify(spyCard, times(0)).setReversed(true);

		cardsList.add(spyCard);
		this.spyCardsClass.flipSelectedCards();
		verify(spyCard, times(1)).setReversed(true);

		cardsList.add(spyCard);
		this.spyCardsClass.flipSelectedCards();
		verify(spyCard, times(3)).setReversed(true);

		assertThrows(NullPointerException.class, () -> {

			this.spyCardsClass.setCardsSelected(null);
			this.spyCardsClass.flipSelectedCards();
		});
	}

}