# 📖 Quotes App (Jetpack Compose)

A simple yet beautiful **Quotes App** built using **Jetpack Compose**.  
The app loads quotes from a `quotes.json` file stored in the assets folder and displays them in a scrollable list.  
Clicking on a quote opens a **detail screen** where the quote is displayed prominently.  

---

## ✨ Features

✅ **Jetpack Compose UI** – Fully built with Compose components  
✅ **LazyColumn** for efficient scrolling  
✅ **Material 3 Design** with Cards, Typography, and Elevations  
✅ **State Management** using `mutableStateOf`  
✅ **BackHandler Support** for proper navigation  
✅ **JSON Parsing** using Gson library  

---



---

## 🏗️ Project Structure

com.example.quotes
┣ dataManager.kt # Handles loading data from assets and managing state
┣ MainActivity.kt # Entry point, sets up Compose content
┣ model/
┃ ┗ quote.kt # Data class for Quote
┣ screens/
┃ ┣ QuoteListScreen.kt # Displays list of quotes
┃ ┣ QuoteListItem.kt # Single quote card UI
┃ ┣ QuoteList.kt # LazyColumn to show multiple items
┃ ┗ QuoteDetail.kt # Detailed quote view
┗ assets/
┗ quotes.json # Your quotes data file


---

## ⚡ Tech Stack

- **Language:** Kotlin  
- **UI:** Jetpack Compose  
- **Material:** Material 3 Components  
- **JSON Parsing:** Gson  
- **State Management:** `mutableStateOf`  
- **Navigation:** Custom state-based navigation with `BackHandler`  

---

## 📦 Dependencies

Add this in your `build.gradle`:

```kotlin
dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("androidx.compose.ui:ui:<latest_version>")
    implementation("androidx.compose.material3:material3:<latest_version>")
    implementation("androidx.activity:activity-compose:<latest_version>")
}
