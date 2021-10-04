import React from 'react'

export default function CardLayout(props) {
  return <section className='flex flex-col space-y-1 xs:space-y-2'>{props.children}</section>
}
