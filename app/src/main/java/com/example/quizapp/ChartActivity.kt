package com.example.quizapp

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class ChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)
        val webView = findViewById<WebView>(R.id.web_view)
        val unencodedHtml = "<a href=\"https://www.statista.com/statistics/1043366/novel-coronavirus-2019ncov-cases-worldwide-by-country/\" rel=\"nofollow\">" +
                "<img src=\"https://www.statista.com/graphic/1/1043366/novel-coronavirus-2019ncov-cases-worldwide-by-country.jpg\" alt=\"Statistic: Number of novel coronavirus (COVID-19) cases worldwide as of April 1, 2020, by country* | Statista\" style=\"width: 100%; height: auto !important; max-width:1000px;-ms-interpolation-mode: bicubic;\"/></a><br />Find more statistics at  <a href=\"https://www.statista.com\" rel=\"nofollow\">Statista</a>"
        val html = """<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">

  <title>The HTML5 Herald</title>
  <meta name="description" content="The HTML5 Herald">
  <meta name="author" content="SitePoint">

  <link rel="stylesheet" href="css/styles.css?v=1.0">

</head>

<body>
$unencodedHtml</body>
</html>"""
        webView.loadData(html, "text/html; charset=utf-8", "UTF-8")
    }
}