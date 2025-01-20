/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var hasMatch = function (s, p) {
  const [prefix, suffix] = p.split("*");
  const prefixIndex = s.indexOf(prefix);
  if (prefixIndex === -1) return false;
  const start = prefixIndex + prefix.length;
  return s.substring(start).includes(suffix);
};
