calcCirc :: Float -> Float
calcCirc r = pi * r^2

jurosSimples :: Float -> Float -> Float -> Float
jurosSimples dinheiro taxa tempo = dinheiro * taxa * tempo

maior :: Ord a => a -> a -> a
maior = max

sinal :: (Ord a, Num a) => a -> Int
sinal x
  | x > 0     = 1
  | x < 0     = -1
  | otherwise = 0

bhaskara :: Floating a => a -> a -> a -> (a, a)
bhaskara a b c
  | delta < 0 = error "Raízes complexas"
  | otherwise = ((-b + raiz) / (2 * a), (-b - raiz) / (2 * a))
  where
    delta = b^2 - 4*a*c
    raiz = sqrt delta

fatorial :: (Eq a, Num a) => a -> a
fatorial 0 = 1
fatorial n = n * fatorial (n - 1)

mdc :: Integral a => a -> a -> a
mdc a 0 = a
mdc a b = mdc b (a `mod` b)

fibonacci :: Int -> Int
fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n = fibonacci (n - 1) + fibonacci (n - 2)

somaLista :: [Int] -> Int
somaLista [] = 0
somaLista (x:xs) = x + somaLista xs

menorElemento :: Ord a => [a] -> a
menorElemento = minimum

fibSeq :: Int -> [Int]
fibSeq n = map fibonacci [0..n]

contido :: Eq a => a -> [a] -> Bool
contido = elem

ordenar :: Ord a => [a] -> [a]
ordenar [] = []
ordenar (x:xs) = ordenar menores ++ [x] ++ ordenar maiores
  where
    menores = filter (<= x) xs
    maiores = filter (> x) xs

intercalar :: [a] -> [a] -> [a]
intercalar [] ys = ys
intercalar xs [] = xs
intercalar (x:xs) (y:ys) = x : y : intercalar xs ys
