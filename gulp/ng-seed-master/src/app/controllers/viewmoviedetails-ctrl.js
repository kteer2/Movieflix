/**
 * Created by Chinmay on 12/12/2016.
 */
(function(){

  angular.module('plunker').controller('moviedetailsctrl', moviedetailsctrl);

  moviedtlsctrl.movie = [

    {
      "Title": "Avengers: Age of Ultron",
      "Year": 2015,
      "Rated": "PG-13",
      "Released": "2015-05-01",
      "Runtime": "141 min",
      "Genre": "Action, Adventure, Sci-Fi",
      "Director": "Joss Whedon",
      "Writer": "Joss Whedon, Stan Lee (Marvel comics), Jack Kirby (Marvel comics)",
      "Actors": "Robert Downey Jr., Chris Hemsworth, Mark Ruffalo, Chris Evans",
      "Plot": "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it's up to Earth's Mightiest Heroes to stop the villainous Ultron from enacting his terrible plans.",
      "Language": "English",
      "Country": "USA",
      "Awards": "1 win & 12 nominations.",
      "Poster": "http://ia.media-imdb.com/images/M/MV5BMTU4MDU3NDQ5Ml5BMl5BanBnXkFtZTgwOTU5MDUxNTE@._V1_SX300.jpg",
      "Metascore": 66,
      "imdbRating": 7.6,
      "imdbVotes": 370909,
      "imdbID": "tt2395427",
      "Type": "movie"
    },
    {
      "Title": "The Avengers",
      "Year": 2012,
      "Rated": "PG-13",
      "Released": "2012-05-04",
      "Runtime": "143 min",
      "Genre": "Action, Sci-Fi, Thriller",
      "Director": "Joss Whedon",
      "Writer": "Joss Whedon (screenplay), Zak Penn (story), Joss Whedon (story)",
      "Actors": "Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth",
      "Plot": "Earth's mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity.",
      "Language": "English, Russian",
      "Country": "USA",
      "Awards": "Nominated for 1 Oscar. Another 35 wins & 76 nominations.",
      "Poster": "http://ia.media-imdb.com/images/M/MV5BMTk2NTI1MTU4N15BMl5BanBnXkFtZTcwODg0OTY0Nw@@._V1_SX300.jpg",
      "Metascore": 69,
      "imdbRating": 8.1,
      "imdbVotes": 920458,
      "imdbID": "tt0848228",
      "Type": "movie"
    },
    {
      "Title": "The Shawshank Redemption",
      "Year": 1994,
      "Rated": "R",
      "Released": "1994-10-14",
      "Runtime": "142 min",
      "Genre": "Crime, Drama",
      "Director": "Frank Darabont",
      "Writer": "Stephen King (short story \"Rita Hayworth and Shawshank Redemption\"), Frank Darabont (screenplay)",
      "Actors": "Tim Robbins, Morgan Freeman, Bob Gunton, William Sadler",
      "Plot": "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
      "Language": "English",
      "Country": "USA",
      "Awards": "Nominated for 7 Oscars. Another 14 wins & 20 nominations.",
      "Poster": "http://ia.media-imdb.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1_SX300.jpg",
      "Metascore": 80,
      "imdbRating": 9.3,
      "imdbVotes": 1590699,
      "imdbID": "tt0111161",
      "Type": "movie"
    },
    {
      "Title": "Batman Begins",
      "Year": 2005,
      "Rated": "PG-13",
      "Released": "2005-06-15",
      "Runtime": "140 min",
      "Genre": "Action, Adventure",
      "Director": "Christopher Nolan",
      "Writer": "Bob Kane (characters), David S. Goyer (story), Christopher Nolan (screenplay), David S. Goyer (screenplay)",
      "Actors": "Christian Bale, Michael Caine, Liam Neeson, Katie Holmes",
      "Plot": "After training with his mentor, Batman begins his war on crime to free the crime-ridden Gotham City from corruption that the Scarecrow and the League of Shadows have cast upon it.",
      "Language": "English, Urdu, Mandarin",
      "Country": "USA, UK",
      "Awards": "Nominated for 1 Oscar. Another 16 wins & 63 nominations.",
      "Poster": "http://ia.media-imdb.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg",
      "Metascore": 70,
      "imdbRating": 8.3,
      "imdbVotes": 906246,
      "imdbID": "tt0372784",
      "Type": "movie"
    },
    {
      "Title": "The Dark Knight",
      "Year": 2008,
      "Rated": "PG-13",
      "Released": "2008-07-18",
      "Runtime": "152 min",
      "Genre": "Action, Crime, Drama",
      "Director": "Christopher Nolan",
      "Writer": "Jonathan Nolan (screenplay), Christopher Nolan (screenplay), Christopher Nolan (story), David S. Goyer (story), Bob Kane (characters)",
      "Actors": "Christian Bale, Heath Ledger, Aaron Eckhart, Michael Caine",
      "Plot": "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, the caped crusader must come to terms with one of the greatest psychological tests of his ability to fight injustice.",
      "Language": "English, Mandarin",
      "Country": "USA, UK",
      "Awards": "Won 2 Oscars. Another 141 wins & 126 nominations.",
      "Poster": "http://ia.media-imdb.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg",
      "Metascore": 82,
      "imdbRating": 9.0,
      "imdbVotes": 1564829,
      "imdbID": "tt0468569",
      "Type": "movie"
    },
    {
      "Title": "The Dark Knight Rises",
      "Year": 2012,
      "Rated": "PG-13",
      "Released": "2012-07-20",
      "Runtime": "164 min",
      "Genre": "Action, Thriller",
      "Director": "Christopher Nolan",
      "Writer": "Jonathan Nolan (screenplay), Christopher Nolan (screenplay), Christopher Nolan (story), David S. Goyer (story), Bob Kane (characters)",
      "Actors": "Christian Bale, Gary Oldman, Tom Hardy, Joseph Gordon-Levitt",
      "Plot": "Eight years after the Joker's reign of anarchy, the Dark Knight, with the help of the enigmatic Selia, is forced from his imposed exile to save Gotham City, now on the edge of total annihilation, from the brutal guerrilla terrorist Bane.",
      "Language": "English",
      "Country": "USA, UK",
      "Awards": "Nominated for 1 BAFTA Film Award. Another 44 wins & 98 nominations.",
      "Poster": "http://ia.media-imdb.com/images/M/MV5BMTk4ODQzNDY3Ml5BMl5BanBnXkFtZTcwODA0NTM4Nw@@._V1_SX300.jpg",
      "Metascore": 78,
      "imdbRating": 8.5,
      "imdbVotes": 1070247,
      "imdbID": "tt1345836",
      "Type": "movie"
    }
  ];



  function moviedetailsctrl ($location) {
    var moviedtlsctrl = this;

    moviedtlsctrl.goToMain = function() {

      $location.path('/viewmovies');
    };

    moviedtlsctrl.goToHome = function() {

      $location.path('/firstpage');
    };
  }

})();
