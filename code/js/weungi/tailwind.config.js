module.exports = {
  mode: "jit",
  purge: ["./src/**/*.{js,jsx,ts,tsx}", "./index.html"],
  darkMode: "class", // or 'media' or 'class'
  theme: {
    screens: {
      xs: "368px",
      // => @media (min-width: 420px) { ... }

      sm: "576px",
      // => @media (min-width: 576px) { ... }

      md: "768px",
      // => @media (min-width: 768px) { ... }

      lg: "1024px",
      // => @media (min-width: 1024px) { ... }

      xl: "1280px",
      // => @media (min-width: 1280px) { ... }

      "2xl": "1536px",
      // => @media (min-width: 1536px) { ... }
    },
    extend: {
      fontFamily: {
        urbanist: '"Urbanist", sans-serif',
      },
    },
  },
  variants: {
    extend: {},
  },
  plugins: [],
}
