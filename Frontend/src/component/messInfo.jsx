import { motion } from "framer-motion";

export default function MessInfo() {
  const messData = {
    messName: "ApnaTiffin",
    address: "123 Street, City",
    contactNumber: "9876543210",
    tiffinRate: 80.0,
    monthlyRate: 2400.0,
    openingTime: "11:00:00",
    closingTime: "23:00:00",
  };

  return (
    <div className="flex items-center justify-center min-h-screen bg-gradient-to-r from-blue-500 to-purple-600 p-6">
      <motion.div
        initial={{ opacity: 0, scale: 0.8 }}
        animate={{ opacity: 1, scale: 1 }}
        transition={{ duration: 0.6 }}
        className="w-full max-w-md bg-white shadow-lg rounded-2xl p-6 text-gray-800"
      >
        <h2 className="text-3xl font-bold text-center text-gray-900 mb-4">
          {messData.messName}
        </h2>
        <p className="text-lg text-gray-700">
          📍 <strong>Address:</strong> {messData.address}
        </p>
        <p className="text-lg text-gray-700">
          📞 <strong>Contact:</strong> {messData.contactNumber}
        </p>
        <p className="text-lg text-gray-700">
          🍽 <strong>Tiffin Rate:</strong> <span className="text-green-600 font-semibold">₹{messData.tiffinRate}</span>
        </p>
        <p className="text-lg text-gray-700">
          🏷 <strong>Monthly Rate:</strong> <span className="text-blue-600 font-semibold">₹{messData.monthlyRate}</span>
        </p>
        <p className="text-lg text-gray-700">
          ⏰ <strong>Timings:</strong> {messData.openingTime} - {messData.closingTime}
        </p>
      </motion.div>
    </div>
  );
}
