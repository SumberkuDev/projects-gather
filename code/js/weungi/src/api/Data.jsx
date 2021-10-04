import axios from 'axios'
import { debounce } from 'lodash'
import React, { createContext, useCallback, useEffect, useRef, useState } from 'react'

export const Data = createContext()

export default function dataProvider(props) {
  const [data, setData] = useState(null)
  const [searchVal, setSearchVal] = useState('Jakarta')
  const [err, setErr] = useState(false)
  const searchInput = useRef()

  useEffect(() => {
    if (searchVal.length > 0) getData()
  }, [searchVal])

  async function getData() {
    const yourApiKey = ''
    // to use this app, register to openweathermap and get your own apikey

    try {
      const responses = await axios.get(
        `https://api.openweathermap.org/data/2.5/weather?q=${searchVal}&lang=id&units=metric&appid=${yourApiKey}`,
      )
      const data = await responses.data
      setData(data)
      setErr(false)
    } catch (err) {
      if (err) {
        if (err.response.status === 404) {
          console.error(
            `oops ${err.response.status} error, cannot found ${searchInput.current.value}`,
          )
          setErr(true)
        } else if (err.response.status >= 500) {
          console.error(
            `oops ${err.response.status} error, there's a problem with the server, try again later`,
          )
          setErr(true)
        }
      }
      setErr(true)
    }
  }

  const changeHandler = () => {
    setSearchVal(searchInput.current.value)
  }
  const debounceHandler = useCallback(debounce(changeHandler, 1500))

  return (
    <Data.Provider
      value={{
        data,
        searchVal,
        setSearchVal,
        searchInput,
        debounceHandler,
        err,
      }}>
      {props.children}
    </Data.Provider>
  )
}
