def f(n):
  n.sort()
  r, l = [], len(n)
  for i in range(l - 2):
    if i > 0 and n[i] == n[i - 1]:
      continue
    j, k = i + 1, l - 1
    while j < k:
      t = n[i] + n[j] + n[k]
      if t < 0:
        j += 1
      elif t > 0:
        k -= 1
      else:
        r.append([n[i], n[j], n[k]])
        while j < k and n[j] == n[j + 1]:
          j += 1
        while j < k and n[k] == n[k - 1]:
          k -= 1
        j += 1
        k -= 1
  return r
