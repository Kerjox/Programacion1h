import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CardsTest {

	@Spy
	private List<Card> mockCardsSelected;

	@Mock
	private Cards cardsClass;

	@Mock
	private List<Card> mockCards;
	@Mock
	private Card mockCard;
	@Mock
	private Image mockBackImage;

	@Test
	@DisplayName("Paint Test")
	void paintTest() {

	}

	@Test
	void cardClickedTest() {

	}

	@Test
	void flipIncorrectCardsTest() {

		//when(this.cards.getBackImage()).thenReturn(null);
		//when(card.getImage(anyInt())).thenReturn(null);

		mockCards = new ArrayList<>();

		for (int i = 0; i < 16; i++) {

			mockCards.add(this.mockCard);
		}

		System.out.println(cardsClass);
		when(cardsClass.getCards()).thenReturn(mockCards);

		this.mockCardsSelected = new ArrayList<>();
		this.cardsClass.setCardsSelected(this.mockCardsSelected);
		this.cardsClass.setCorrect(true);

		when(this.mockCardsSelected.size()).thenReturn(2);
		//when(this.cardsSelected.get(Mockito.anyInt())).thenReturn(new Card(null, 0, null));

		verify(this.mockCardsSelected, times(1)).clear();

	}

}