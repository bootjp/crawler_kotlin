package me.bootjp.crawler_kotlin

import org.jsoup.Jsoup
import sun.applet.Main

import java.io.IOException
import java.util.logging.Level
import java.util.logging.Logger

fun main(args: Array<String>) {
    // write your code here
    try {
        val doc = Jsoup.connect("https://www.tokopedia.com/nusantaranb/baterai-laptop-oem-hp-mini-1000-1100-compaq-mini-700-hstnn-ob81?src=topads").get()

        val title = doc.select("h1.product-title a")
        val price = doc.select(".product-box-content span[itemprop='price']")
        val description = doc.select(".product-info-holder p[itemprop='description']")

        println("Nama Produk : " + title.text())
        println("Harga : " + price.text())
        println("Deskripsi : " + description.text())

    } catch (ex: IOException) {
        Logger.getLogger(Main::class.java.name).log(Level.SEVERE, null, ex)
    }

}
