package com.cursosandroidant.filmsjcref.dataAccess

import com.example.kotlinappfilmsjc.Film


object FakeDatabase {
    fun getAllFilms() = listOf<Film>(
        Film("Interstellar", "In 2067, ex-NASA pilot Cooper is forced to work as a farmer due to a global famine caused by blight. He ignores his daughter, Murph, when she claims a ghost is communicating to her through her bookshelf, but later finds dust particles forming an inexplicable pattern on Murph's bedroom floor. ",
            4.5f, "https://upload.wikimedia.org/wikipedia/en/b/bc/Interstellar_film_poster.jpg"),
        Film("Godzilla", "An iguana nest is exposed to the fallout of a military nuclear test in French Polynesia. In the South Pacific Ocean, a Japanese fishing vessel is suddenly attacked by a giant creature, with only one fisherman surviving.",
            2.5f, "https://upload.wikimedia.org/wikipedia/en/thumb/2/2e/Godzilla_%281998_Movie_Poster%29.jpg/220px-Godzilla_%281998_Movie_Poster%29.jpg"),
        Film("Gran Torino", "Cantankerous, bigoted Korean War veteran and retired Ford factory worker Walt Kowalski is widowed after 50 years of marriage.",
            4.8f, "https://upload.wikimedia.org/wikipedia/en/thumb/c/c6/Gran_Torino_poster.jpg/220px-Gran_Torino_poster.jpg"),
        Film("Pride & Prejudice", "During the late 18th century, Mr. and Mrs. Bennet and their daughters – Jane, Elizabeth, Mary, Kitty, and Lydia.",
            4.0f, "https://upload.wikimedia.org/wikipedia/en/thumb/0/03/Prideandprejudiceposter.jpg/220px-Prideandprejudiceposter.jpg"),
        Film("Split", "Kevin Wendell Crumb, a man struggling with dissociative identity disorder (DID) rooted in his history of childhood abuse and abandonment, has been managing living with his 23 distinct personalities well for several years with help from his therapist, Dr. Karen Fletcher.",
            4.4f, "https://upload.wikimedia.org/wikipedia/en/3/31/Split_%282017_film%29.jpg"),
        Film("Up", "As a young boy, 10-year-old Carl Fredricksen idolizes explorer Charles Muntz.",
            5.0f, "https://upload.wikimedia.org/wikipedia/en/0/05/Up_%282009_film%29.jpg"),
        Film("Braveheart", "In 1280, King Edward \"Longshanks\" invades and conquers Scotland following the death of Alexander III of Scotland, who left no heir to the throne.",
            4.9f, "https://upload.wikimedia.org/wikipedia/en/thumb/5/55/Braveheart_imp.jpg/220px-Braveheart_imp.jpg"),
        Film("Pitch Perfect", "During the 2011 ICCA Finals at the Lincoln Center, Barden University's all-female a cappella group, the Barden Bellas, lose to their all-male rival group, the Barden Treblemakers.",
            3.9f, "https://upload.wikimedia.org/wikipedia/en/b/b9/Pitch_Perfect_movie_poster.jpg"),
        Film("One day", "Two friends, on the same day.",
            4.4f, "https://upload.wikimedia.org/wikipedia/en/a/ad/One_Day_Poster.jpg"),
        Film("Troy", "In Ancient Greece, King Agamemnon of Mycenae finally unites the Greek kingdoms after decades of warfare, forming a loose alliance under his rule.",
            4.1f, "https://upload.wikimedia.org/wikipedia/en/thumb/b/b8/Troy2004Poster.jpg/220px-Troy2004Poster.jpg"),
        Film("Bolt", "A White Swiss Shepherd puppy named Bolt is adopted by a 7-year-old girl named Penny.",
            2.9f, "https://upload.wikimedia.org/wikipedia/en/4/44/Bolt_ver2.jpg")
    )
}