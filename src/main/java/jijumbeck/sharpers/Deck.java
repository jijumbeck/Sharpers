package jijumbeck.sharpers;

/*
Deck - сущность колоды карт.

getCard - возвращает новую карту.
 */
public class Deck {
    synchronized Card getCard(){
        return new Card();
    }
}
