import React, { useContext } from 'react'
import HeaderLayout from '../layout/HeaderLayout'
import { Theme } from '../util/Theme'

export default function Header() {
  const { title, icon, toggleIcon } = useContext(Theme)

  const styles = {
    head: 'flex items-center text-lg sm:text-xl font-bold space-x-1 select-none uppercase text-blue-500',
    toggler:
      'grid place-items-center w-10 h-10 rounded-full text-base xs:text-lg sm:text-xl cursor-pointer hover:bg-gray-100 text-gray-700 dark:text-gray-400 dark:hover:bg-gray-800',
  }

  return (
    <HeaderLayout>
      <h5 ref={title} className={styles.head}>
        <svg
          xmlns='http://www.w3.org/2000/svg'
          width='24'
          height='24'
          viewBox='0 0 24 24'
          style={{
            fill: 'rgb(59,130,246)',
            transform: 'none',
          }}>
          <path d='M18.944 11.112C18.507 7.67 15.56 5 12 5 9.244 5 6.85 6.611 5.757 9.15 3.609 9.792 2 11.82 2 14c0 2.757 2.243 5 5 5h11c2.206 0 4-1.794 4-4a4.01 4.01 0 0 0-3.056-3.888z'></path>
        </svg>

        <span>Weungi</span>
      </h5>

      <div
        ref={icon}
        onClick={() => {
          document.documentElement.classList.toggle('dark')
          toggleIcon.current.classList.toggle('bx-moon')
          toggleIcon.current.classList.toggle('bx-sun')
        }}
        className={styles.toggler}>
        <i className='bx bx-moon' ref={toggleIcon}></i>
      </div>
    </HeaderLayout>
  )
}
