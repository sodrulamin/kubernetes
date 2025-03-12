import type { NextConfig } from "next";

const nextConfig: NextConfig = {
  /* config options here */
  reactStrictMode: true,
  async redirects () {
    return [
      {
        source: "/",
        destination: "/bookmarks",
        permanent: true
      }
    ]
  }
};

export default nextConfig;
