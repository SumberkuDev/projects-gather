import React, { useContext } from 'react'
import { Data } from '../api/Data'

export default function Card({ data, status }) {
  const { searchInput } = useContext(Data)
  const styles = {
    article:
      'w-full xs:max-w-md mx-auto rounded-md p-2 xs:p-4 shadow dark:shadow-none bg-white dark:bg-gray-800',
    articleBody: 'grid place-items-center relative',
    articleImage: 'w-40 h-40 xs:w-48 xs:h-48 md:w-52 md:h-52 object-cover animate-pulse',
    articleTemp:
      'text-lg sm:text-xl md:text-2xl lg:text-3xl font-semibold text-gray-700 dark:text-gray-300',
    articleCity:
      'text-sm sm:text-lg md:text-xl lg:text-2xl font-bold text-gray-700 dark:text-gray-400',
    articleDesc:
      'text-xs sm:tex-sm md:text-base lg:text-lg font-semibold text-gray-600 dark:text-gray-500',
    arcticleErrBody:
      'text-center text-3xl xs:text-4xl lg:text-5xl mb-2 sm:mb-4 lg:mb-6 font-bold text-gray-700 dark:text-gray-300',
    articleErrDesc:
      'text-center text-base font-semibold xs:text-lg sm:text-xl md:text-2xl lg:text-3xl text-red-500 dark:text-red-400',
  }

  if (data && !status) {
    const {
      name,
      main: { temp },
      weather: [{ description, icon }],
    } = data
    const image = `https://openweathermap.org/img/wn/${icon}@4x.png`

    return (
      <article className={styles.article}>
        <div className={styles.articleBody}>
          <img src={image} alt='' className={styles.articleImage} />
          <h4 className={styles.articleTemp}>{`${temp} °c`}</h4>
          <h5 className={styles.articleCity}>{name}</h5>
          <span className={styles.articleDesc}>{description}</span>
        </div>
      </article>
    )
  }
  return (
    <article className={styles.article}>
      <div className={styles.arcticleErrBody}>ಠ_ಠ</div>
      <h5 className={styles.articleErrDesc}>{`Can't Found ${searchInput.current.value}`}</h5>
    </article>
  )
}
