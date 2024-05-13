package com.id.newsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private val newsData: MutableList<NewsData> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jsonNewses = JSONArray(
            """[
            {
                "title": "2024 Wells Fargo Championship leaderboard: Rory McIlroy closes in on Xander Schauffele entering final round - CBS Sports",
                "description": "McIlroy is within one shot of Schauffele, which should make for an exciting finish on Sunday at Quail Hollow",
                "urlToImage": "https://sportshub.cbsistatic.com/i/r/2024/05/11/364181a2-9e39-4658-9c1d-585461837fde/thumbnail/1200x675/e64f6be1c9dec67019f1dafcf127cfee/rory-mcilroy.jpg"
            },
            {
                "title": "Mets barely avoid getting no-hit as Braves, Max Fried dominate listless lineup - New York Post ",
                "description": "The Mets were nearly no-hit on Saturday.",
                "urlToImage": "https://nypost.com/wp-content/uploads/sites/2/2024/05/newspress-collage-tzxpmwfzv-1715471775618.jpg?quality=75&strip=all&1715457424&w=1024"
            },
            {
                "title": "SpaceX Starship To Have Fourth Flight In 3-5 Weeks, Elon Musk Says - NDTV",
                "description": "SpaceX Starship rocket, a futuristic vehicle designed to eventually carry astronauts to the moon and beyond, will probably have its fourth flight in 3-5 weeks, the company's Chief Executive Elon Musk said in a post on social media platform X on Sat",
                "urlToImage": "https://c.ndtvimg.com/2024-05/6r1fnrvg_spacexs-starship-rocket_625x300_12_May_24.jpeg?ver-20240506.08"
            },
            {
                "title": "Pirates prospect Paul Skenes strikes out seven in MLB debut - ESPN",
                "description": "Paul Skenes, the top-ranked pitching prospect in baseball, had a promising major league debut for the Pittsburgh Pirates on Saturday at PNC Park, working into the fifth inning against the Chicago Cubs while throwing 17 pitches of 100 mph or more.",
                "urlToImage": "https://a3.espncdn.com/combiner/i?img=%2Fphoto%2F2024%2F0511%2Fr1331609_1296x729_16%2D9.jpg"
            },
            {
                "title": "Rahul Gandhi moots debate with PM Modi; he’s merely an MP, mocks BJP - The Times of India",
                "description": "India News: The remark comes as Congress leader Rahul Gandhi on Saturday said he or party chief Mallikarjun Kharge would be pleased to participate in such a discu",
                "urlToImage": "https://static.toiimg.com/thumb/msid-110043668,width-1070,height-580,imgsize-51232,resizemode-75,overlay-toi_sw,pt-32,y_pad-40/photo.jpg"
            }]"""
        )
        (0 until jsonNewses.length()).forEach {
            val news = NewsData(
                jsonNewses.getJSONObject(it).getString("description"),
                jsonNewses.getJSONObject(it).getString("title"),
                jsonNewses.getJSONObject(it).getString("urlToImage")
            )
            newsData.add(news)
        }
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        val adapter = NewsAdapter(newsData)
        recyclerView.adapter = adapter
    }
}