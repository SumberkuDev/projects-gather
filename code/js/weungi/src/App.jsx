import React from "react"
import Header from "./component/Header"
import ThemeProvider from "./util/Theme"
import Main from "./component/Main"
import "./App.css"

function App() {
  return (
    <ThemeProvider>
      <Header />
      <Main />
    </ThemeProvider>
  )
}

export default App
