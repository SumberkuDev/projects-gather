import { gsap } from 'gsap'
import React, { createContext, useEffect, useRef } from 'react'

export const Theme = createContext()
export default function ThemeProvider(props) {
  let title = useRef()
  let icon = useRef()
  let heading = useRef()
  let searchbar = useRef()
  let toggleIcon = useRef()

  useEffect(() => {
    gsap.from(title.current, {
      opacity: 0,
      x: -50,
      transitionProperty: 'ease',
    })

    gsap.from(icon.current, {
      opacity: 0,
      x: 50,
      transitionProperty: 'ease',
    })

    gsap.from(heading.current, {
      opacity: 0,
      y: 50,
      transitionProperty: 'ease',
    })

    gsap.from(searchbar.current, {
      opacity: 0,
      y: 50,
      delay: 0.5,
      transitionProperty: 'ease',
    })
  }, [])

  return (
    <Theme.Provider
      value={{
        title,
        icon,
        heading,
        searchbar,
        toggleIcon,
      }}>
      {props.children}
    </Theme.Provider>
  )
}
